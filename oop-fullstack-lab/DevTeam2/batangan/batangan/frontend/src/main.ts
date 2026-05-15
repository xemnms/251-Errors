import './style.css';
import { productService, Product } from './productService';

// DOM Elements
const app = document.getElementById('app')!;
let products: Product[] = [];
let editingId: number | null = null;

// Initialize the app
async function init(): Promise<void> {
  renderApp();
  await loadProducts();
}

// Render the main app structure
function renderApp(): void {
  app.innerHTML = `
    <div class="container">
      <div class="header">
        <h1>🌸Batangan's Market🌸</h1>
        <p>Manage your products with full CRUD operations!</p>
      </div>

      <div id="messageContainer"></div>

      <div class="form-section">
        <h2>${editingId ? 'Edit Product' : 'Add New Product'}</h2>
        <form id="productForm">
          <div class="form-group">
            <label for="name">Product Name *</label>
            <input type="text" id="name" name="name" required />
          </div>
          <div class="form-group">
            <label for="description">Description</label>
            <textarea id="description" name="description" rows="3"></textarea>
          </div>
          <div class="form-group">
            <label for="price">Price *</label>
            <input type="number" id="price" name="price" step="0.01" min="0" required />
          </div>
          <div class="form-group">
            <label for="quantity">Quantity *</label>
            <input type="number" id="quantity" name="quantity" min="0" required />
          </div>
          <div class="form-group">
            <label for="category">Category *</label>
            <input type="text" id="category" name="category" required />
          </div>
          <div class="form-actions">
            <button type="submit" class="btn-save">${editingId ? 'Update Product' : 'Add Product'}</button>
            ${editingId ? '<button type="button" class="btn-cancel">Cancel</button>' : ''}
          </div>
        </form>
      </div>

      <div class="products-section">
        <h2>Products</h2>
        <div id="productsList"></div>
      </div>
    </div>
  `;

  // Attach event listeners
  document.getElementById('productForm')?.addEventListener('submit', handleFormSubmit);
  document.querySelector('.btn-cancel')?.addEventListener('click', resetForm);
  loadProducts();
}

// Load all products
async function loadProducts(): Promise<void> {
  try {
    const productsList = document.getElementById('productsList')!;
    productsList.innerHTML = '<div class="loading">Loading products...</div>';
    
    products = await productService.getAll();
    renderProducts();
  } catch (error) {
    showMessage('Error loading products: ' + (error instanceof Error ? error.message : 'Unknown error'), 'error');
    document.getElementById('productsList')!.innerHTML = '<div class="error">Failed to load products</div>';
  }
}

// Render products list
function renderProducts(): void {
  const productsList = document.getElementById('productsList')!;
  
  if (products.length === 0) {
    productsList.innerHTML = '<p style="text-align: center; color: #6b7280;">No products yet. Create one to get started!</p>';
    return;
  }

  // Reverse the array so newest products appear at the bottom
  const reversedProducts = [...products].reverse();

  productsList.innerHTML = `
    <div class="product-grid">
      ${reversedProducts.map(product => `
        <div class="product-card">
          <div class="product-header">
            <h3>${escapeHtml(product.name)}</h3>
            <button class="btn-delete-inline" onclick="window.deleteProduct(${product.id})" title="Delete product">🗑️</button>
          </div>
          <div class="product-info">
            <p><strong>Description:</strong> ${escapeHtml(product.description || 'N/A')}</p>
            <p><strong>Price:</strong> $${product.price.toFixed(2)}</p>
            <p><strong>Quantity:</strong> ${product.quantity}</p>
            <p><strong>Category:</strong> ${escapeHtml(product.category)}</p>
          </div>
          <div class="product-actions">
            <button class="btn-edit" onclick="window.editProduct(${product.id})">Edit</button>
          </div>
        </div>
      `).join('')}
    </div>
  `;
}

// Handle form submission
async function handleFormSubmit(e: Event): Promise<void> {
  e.preventDefault();

  const form = e.target as HTMLFormElement;
  const formData = new FormData(form);

  const product: Product = {
    name: (formData.get('name') as string).trim(),
    description: (formData.get('description') as string).trim(),
    price: parseFloat(formData.get('price') as string),
    quantity: parseInt(formData.get('quantity') as string),
    category: (formData.get('category') as string).trim(),
  };

  // Validation
  if (!product.name) {
    showMessage('Product name is required', 'error');
    return;
  }
  if (!product.category) {
    showMessage('Product category is required', 'error');
    return;
  }

  try {
    if (editingId) {
      await productService.update(editingId, product);
      showMessage('Product updated successfully', 'success');
    } else {
      await productService.create(product);
      showMessage('Product created successfully', 'success');
    }
    resetForm();
    await loadProducts();
  } catch (error) {
    showMessage('Error saving product: ' + (error instanceof Error ? error.message : 'Unknown error'), 'error');
  }
}

// Edit a product
function editProduct(id: number): void {
  const product = products.find(p => p.id === id);
  if (product) {
    editingId = id;
    renderApp();
    
    setTimeout(() => {
      (document.getElementById('name') as HTMLInputElement).value = product.name;
      (document.getElementById('description') as HTMLTextAreaElement).value = product.description || '';
      (document.getElementById('price') as HTMLInputElement).value = product.price.toString();
      (document.getElementById('quantity') as HTMLInputElement).value = product.quantity.toString();
      (document.getElementById('category') as HTMLInputElement).value = product.category || '';
    }, 0);
  }
}

// Delete a product
async function deleteProduct(id: number): Promise<void> {
  if (confirm('Are you sure you want to delete this product?')) {
    try {
      await productService.delete(id);
      showMessage('Product deleted successfully', 'success');
      await loadProducts();
    } catch (error) {
      showMessage('Error deleting product: ' + (error instanceof Error ? error.message : 'Unknown error'), 'error');
    }
  }
}

// Reset form
function resetForm(): void {
  editingId = null;
  renderApp();
}

// Show message
function showMessage(message: string, type: 'success' | 'error'): void {
  const container = document.getElementById('messageContainer')!;
  container.innerHTML = `<div class="${type}">${escapeHtml(message)}</div>`;
  
  setTimeout(() => {
    container.innerHTML = '';
  }, 5000);
}

// Escape HTML
function escapeHtml(text: string): string {
  const div = document.createElement('div');
  div.textContent = text;
  return div.innerHTML;
}

// Expose functions to window for onclick handlers
(window as any).editProduct = editProduct;
(window as any).deleteProduct = deleteProduct;

// Start the app
init();
