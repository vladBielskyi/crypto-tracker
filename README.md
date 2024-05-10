This API provides endpoints to retrieve reports about currencies and cryptocurrencies.

## Endpoints

### Get Current Exchange Rates Report
- **URL**: `/api/currencies/actual`
- **Method**: `GET`
- **Description**: Retrieves the current exchange rates report.
- **Response**: Returns a JSON object containing the exchange rates report.

### Get Exchange Rates Report for a Specific Date
- **URL**: `/api/currencies/period`
- **Method**: `GET`
- **Description**: Retrieves the exchange rates report for a specific date.
- **Parameters**:
    - `date` (required): The date for which the exchange rates report is requested.
- **Response**: Returns a JSON object containing the exchange rates report for the specified date.

### Get Cryptocurrency Report
- **URL**: `/api/currencies/crypto`
- **Method**: `GET`
- **Description**: Retrieves a report about a specific cryptocurrency pair.
- **Parameters**:
    - `base` (required): The base cryptocurrency for the report.
    - `quote` (required): The quote cryptocurrency for the report.
    - `period` (required): The time series period for the report.
- **Response**: Returns a JSON object containing the cryptocurrency report.

## Example Usage

### Get Current Exchange Rates Report
### Get Exchange Rates Report for a Specific Date
### Get Cryptocurrency Report


## Technologies Used

- Spring Boot
- Spring Data JPA
- Spring Web
- Spring Data Redis
- Jedis
- OkHttp
- PostgreSQL JDBC Driver
- Lombok
