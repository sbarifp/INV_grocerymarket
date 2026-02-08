FROM php:8.2-apache

WORKDIR /var/www/html

RUN docker-php-ext-install pdo pdo_mysql

RUN a2enmod rewrite

COPY . .

RUN chown -R www-data:www-data storage bootstrap/cache

RUN curl -sS https://getcomposer.org/installer | php -- --install-dir=/usr/local/bin --filename=composer

RUN composer install --no-dev --optimize-autoloader

RUN php artisan key:generate

EXPOSE 80
