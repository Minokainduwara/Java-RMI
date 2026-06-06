# RMI (Remote Method Invocation) Project

A comprehensive Java Remote Method Invocation (RMI) application that demonstrates client-server communication and remote object invocation.

## Project Overview

This project implements a classic RMI example where a server hosts multiple product objects and clients can remotely access these products to retrieve their information (name, description, and price) over the network.

## Architecture

### System Components

```
Client Side
├── Client.java               # Main client application
└── Product.java              # Remote interface for product operations

Server Side
├── Server.java               # Main server application  
├── Product.java              # Remote interface (same as client)
├── ProductImpl.java          # Implementation of Product interface
└── ProductImpl.class         # Compiled implementation

Entry Point
└── Main.java                 # Simple hello world example (not part of RMI system)
```

### Key Components

1. **Remote Interface (Product.java)**: Defines the contract for remote operations
   - `getName()` - Returns product name
   - `getDescription()` - Returns product description  
   - `getPrice()` - Returns product price

2. **Implementation (ProductImpl.java)**: Implements the remote interface
   - Contains product data (name, description, price)
   - Provides actual implementations of remote methods

3. **Server (Server.java)**: RMI Server Application
   - Creates multiple product instances
   - Exports objects for remote access
   - Registers objects in RMI registry
   - Hosts 4 different products (Product1-4)

4. **Client (Client.java)**: RMI Client Application
   - Connects to RMI registry
   - Looks up remote objects by name
   - Invokes remote methods to get product information

## Setup Instructions

### Prerequisites

- Java Development Kit (JDK) 8 or higher
- Java Runtime Environment (JRE) 8 or higher
- Integrated Development Environment (IDE) like IntelliJ IDEA, Eclipse, or VS Code

### Configuration

The application is configured for **localhost operation**:
- **Server IP**: 127.0.0.1 (localhost)
- **RMI Registry Port**: 1099
- **Hostname**: 127.0.0.1

## How to Run the RMI System

### Step 1: Compile the Code

```bash
# Compile all Java files
javac -d . src/**/*.java
```

### Step 2: Start the RMI Registry

```bash
# Start RMI registry (in background)
rmiregistry &
```

### Step 3: Start the Server

```bash
# Run the server application
java -cp . server.Server
```

### Step 4: Run the Client

```bash
# Run the client application
java -cp . client.Client
```

### Alternative: Run in IDE

1. **Open the project** in your IDE
2. **Run Server.java** first (right-click → Run)
3. **Run Client.java** second (right-click → Run)

## Expected Output

### Server Output
- Server starts successfully
- Creates 4 product instances
- Exports and registers them in RMI registry
- No console output when running successfully

### Client Output
```
Product Name: Product 1
Product Description: Description of Product 1
Product Price: 10.99
```

## Technical Details

### RMI Flow

1. **Server Initialization**:
   - Creates `ProductImpl` instances with sample data
   - Exports objects using `UnicastRemoteObject.exportObject()`
   - Registers objects in RMI registry with names "Product1" to "Product4"
   - Sets hostname property for network access

2. **Client Operation**:
   - Locates RMI registry on localhost:1099
   - Looks up remote objects by registry names
   - Casts retrieved objects to `Product` interface
   - Invokes remote methods to get product information

### Network Configuration

- **Registry**: Uses default RMI registry port 1099
- **Hostname**: Configured as 127.0.0.1 for local testing
- **Protocol**: Uses Java RMI protocol (JRMP)

### File Structure

```
RMI/
├── README.md                    # This documentation
├── RMI.iml                      # IntelliJ IDEA module configuration
└── src/
    ├── Main.java                # Hello world example (not RMI-related)
    ├── client/
    │   ├── Client.java          # RMI Client application
    │   └── Product.java         # Remote interface
    └── server/
        ├── Product.java         # Remote interface (same as client)
        ├── ProductImpl.java     # Implementation of Product interface
        └── Server.java          # RMI Server application
```

## Troubleshooting

### Common Issues

1. **RMI Registry Not Running**:
   ```
   java.rmi.ConnectException: Connection refused to host: 127.0.0.1; nested exception is: 
   java.net.ConnectException: Connection refused
   ```
   **Solution**: Start `rmiregistry` before running the server

2. **ClassNotFoundException**:
   ```
   java.lang.ClassNotFoundException: client.Product
   ```
   **Solution**: Ensure proper classpath with `-cp .` or use IDE's run configuration

3. **AlreadyBoundException**:
   ```
   java.rmi.server.AlreadyBoundException: Product1
   ```
   **Solution**: Restart the server to clear registry or use different binding names

4. **Security Manager Issues**:
   If using security policies, ensure proper permissions are granted

### Debug Tips

1. **Check Registry**: Verify that objects are properly registered
2. **Network**: Ensure no firewall blocks port 1099
3. **Classpath**: Verify all compiled classes are accessible
4. **Server Order**: Always start server before client

## Dependencies

- Java RMI API (built-in with JDK)
- No external dependencies required

## Development Notes

- The `Main.java` file contains a simple hello world example and is not part of the RMI system
- The project uses separate packages for client and server code organization
- All remote methods throw `RemoteException` as required by RMI specification
- The implementation uses `UnicastRemoteObject` for remote object export

## Educational Purpose

This project serves as a practical demonstration of:
- Remote Method Invocation concepts
- Client-server architecture
- Remote object lifecycle management
- Network programming in Java
- Interface-based remote design patterns

---

*Created for Advanced Programming Course - Semester 5*  
*University of Ruhuna*