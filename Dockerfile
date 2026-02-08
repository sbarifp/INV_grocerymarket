FROM php:8.1-cli

WORKDIR /app

# Install system deps
RUN apt-get update && apt-get install -y \
    git unzip zip curl \
    && rm -rf /var/lib/apt/lists/*

# Install Node.js
RUN curl -fsSL https://deb.nodesource.com/setup_18.x | bash - \
    && apt-get install -y nodejs

# Install PHP extensions
RUN docker-php-ext-install pdo pdo_mysql zip

# Copy project
COPY . .

# Install Composer
RUN curl -sS https://getcomposer.org/installer | php \
    -- --install-dir=/usr/local/bin --filename=composer

RUN composer install --no-dev --optimize-autoloader --no-interaction

# Install frontend deps & build Vite
RUN npm install && npm run build

# Permission
RUN chmod -R 775 storage bootstrap/cache

EXPOSE 8080
