#!/bin/bash

# Set necessary environment variables
export KEYCLOAK_USER=${KEYCLOAK_USER}
export KEYCLOAK_PASSWORD=${KEYCLOAK_PASSWORD}
export DB_VENDOR=${DB_VENDOR}
export DB_ADDR=${DB_ADDR}
export DB_DATABASE=${DB_DATABASE}
export DB_USER=${DB_USER}
export DB_PASSWORD=${DB_PASSWORD}

# Start Keycloak in development mode (change as necessary)
/opt/keycloak/bin/kc.sh start-dev --import-realm

# If any additional custom commands or initialization is required, include them here
