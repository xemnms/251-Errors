# Batangan Frontend

A Vite + TypeScript frontend for the Batangan Product Manager application.

## Features

- Full CRUD operations for products
- Add, view, update, and delete products
- Real-time product list
- Responsive design
- API integration with backend

## Prerequisites

- Node.js 16+ and npm/yarn

## Setup

1. Install dependencies:
```bash
npm install
```

2. Start the development server:
```bash
npm run dev
```

The app will be available at `http://localhost:5173`

## Development

- `npm run dev` - Start development server
- `npm run build` - Build for production
- `npm run preview` - Preview production build

## API Integration

The frontend communicates with the backend API at `http://localhost:8080/products`. 

The API proxy is configured in `vite.config.ts` to route `/api/products` requests to the backend.

## Project Structure

```
src/
├── main.ts           - App entry point and main logic
├── productService.ts - API service for product operations
└── style.css         - Application styles
```

## Building for Production

```bash
npm run build
```

This creates an optimized production build in the `dist` folder.

## Notes

- Make sure your backend is running on `http://localhost:8080`
- The application uses Axios for HTTP requests
- All product data is fetched from and persisted to the backend
