# Specify a base image
FROM node:alpine

# Set working directory
WORKDIR /usr/app/

# Copy required files
COPY ./package.json ./

# Install some dependencies
RUN npm install

COPY ./ ./

# Default command
CMD ["npm", "start"]