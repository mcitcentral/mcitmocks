# mcitmocks
## Setup

### Database

- This project uses PostgreSQL for a database, so please download Postgres
  from [their website](https://www.postgresql.org) if you do not already have it.
- Create a database named `mcitmocks-dev` to use in the dev environment

### Starting the Server

- Build and run the main MCITMocksApplication in your IDE
- By default, this should start at `localhost:8080`

### Starting the Client

- Please download and use `yarn` as a package manager
- In order to use live reload features during development, we've set up a proxy.
- For development, please have the server running first in the background.

``` js
cd src/main/client
yarn
yarn dev
``` 

- By default, this will start at `localhost:3000`
