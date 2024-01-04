
##  Read a file and write data into multiple Files
// Input
// Csv file
// Fomat: 1st colu = SquareFeet, 2nd, Bedroom, 3rd bathroom
// Frequency: Once

// Processing
System to filter records by Bedrooms with specific bedroom sizes,
bathrooms, neighbrhoods, price.
- User may query give me all flats which falls under 50k or x range price
- 

// Simple design
- DataReaderService - FileReaderService

DataReader - interface (generic)

FileReader - interface (generic)

CsvFileReader - Class (specific)

JsonFileReader - class (specific)



// Output
console,
csv
json