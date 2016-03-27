# Java ValidatedInput

This class helps with input validation in Java.

## Usage

### Example 1

In this example we are validating **username**

```java
//Getting the string
String username = "dirchev";

// Validating the username.
// It is required.
// Must have more than 3 characters and less than 15 characters.
// Must contain letters and numbers only.
ValidatedInput validated = new ValidatedInput(username, "Username").required().alphanum().min_length(3).max_length(15);

// Getting validation result
validated.isValid();
// > true
```

### Example 2

In this example we are validating **first name**

```java
//Getting the string
String firstName = "Fakename123Fakename123Fakename123Fakename123";

// Validating the name.
// It is required.
// Must have more than 3 characters and less than 15 characters.
// Must contain only letters.
ValidatedInput validated = new ValidatedInput(firstName, "First Name").required().alpha().min_length(3).max_length(15);

// Getting validation result
validated.isValid();
// > false

// Getting validation messages
validated.getValidationMessages();
// > ['First Name' must include only letters., 'First Name' must have less than 15 characters.]
```

## Available Validations

### Required
```
// Checks if the string has at least 1 character
.required()
```

### Alphanum
```
// Checks if the string contains only upper or lower case letters or numbers
.alphanum()
```

### Alpha
```
// Checks if the string contains only upper or lower case letters
alpha()
```

### Integer
```
// Checks if the string contains only numbers
integer()
```

### Max length
```
// Checks if the string length is more than given length
min_length(length)
```

### Min length
```
// Checks if the string length is less than the given length
max_length(length)
```

### Email
```
// Checks if the string is a valid email
.email()
```
