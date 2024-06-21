#!/bin/bash
set -e

# Start Keycloak
/opt/keycloak/bin/kc.sh start --spi-theme-dynamic-enabled=true &

# Wait for Keycloak to start
until $(curl --output /dev/null --silent --head --fail http://localhost:8080); do
  echo 'Waiting for Keycloak to start...'
  sleep 5
done

# Import realm
/opt/keycloak/bin/kc.sh import --file /opt/keycloak/data/import/my-realm.json

# Keep the container running
tail -f /dev/null
