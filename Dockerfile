FROM php:8.1-cli

WORKDIR /app

# System dependencies (INI KUNCI UTAMA)
RUN apt-get update && apt-get install -y \
    git \
    unzip \
    zip \
    curl \
    libzip-dev \
    && rm -rf /var/lib/apt/lists/*

# Install Node.js 18 untuk Vite
RUN curl -fsSL https://deb.nodesource.com/setup_18.x | bash - \
    && apt-get install -y nodejs

# PHP extensions
RUN docker-php-ext-install pdo pdo_mysql zip

# Copy project
COPY . .

# Install Composer
RUN curl -sS https://getcomposer.org/installer | php \
    -- --install-dir=/usr/local/bin --filename=composer

RUN composer install --no-dev --optimize-autoloader --no-interaction

# Build Vite assets (INI YANG MENGHILANGKAN ERROR MANIFEST)
RUN npm install
RUN npm run build

# Permission Laravel
RUN chmod -R 775 storage bootstrap/cache

EXPOSE 8080
