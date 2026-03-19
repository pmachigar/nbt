# NBT Platform Frontend Architecture

## 1. Overview
The frontend of the NBT Platform is divided into two major clients:
- **Web**: A modular **Micro-Frontend** architecture built with **Next.js**.
- **Mobile**: A cross-platform mobile application built with **React Native**.

## 2. Web Micro-Frontend Architecture (Module Federation)
The web application is split into multiple independent Next.js applications that are integrated together securely at runtime. This allows autonomous teams to develop, test, and deploy features independently.

```mermaid
graph TD
    Client["Browser"] --> Host["Host Application (Port 3000)"]
    
    subgraph Micro-Frontends
        Host -- Routes /login --> Login["Login Remote (Port 3001)"]
        Host -- Routes /dashboard --> Dashboard["Dashboard Remote (Port 3002)"]
        Host -- Routes /user-mgmt --> UserMgmt["User Management Remote (Port 3003)"]
    end
```

### Components:
- **`host`**: The main shell application. It manages global state, routing, and loading remote modules.
- **`login`**: Handles user authentication, credential validation (JWT and 2FA), and session management.
- **`dashboard`**: Displays the main user overview, statistics, and billing summaries.
- **`user-mgmt`**: Handles user profile properties, subscription settings, and account maintenance.

## 3. Component Hierarchy (Web Setup)

```mermaid
classDiagram
    class HostApp {
        +GlobalLayout
        +NavigationState
        +SessionProvider
    }
    
    class RemoteLogin {
        +AuthForm
        +OAuthButtons
        +MFAChallenge
    }
    
    class RemoteDashboard {
        +StatsWidget
        +RecentActivity
        +BillingSummary
    }
    
    HostApp "1" *-- "1" RemoteLogin : loads dynamically
    HostApp "1" *-- "1" RemoteDashboard : loads dynamically
```

## 4. Mobile Application Architecture
The mobile application (located in `frontend/mobile`) targets both iOS and Android platforms via React Native. 

```mermaid
sequenceDiagram
    participant User
    participant MobileApp as React Native App
    participant APIGW as API Gateway (Backend)
    
    User->>MobileApp: Open App & Login
    MobileApp->>APIGW: Authenticate (REST/gRPC)
    APIGW-->>MobileApp: JWT Token
    MobileApp->>MobileApp: Store in SecureStorage
    MobileApp->>APIGW: Fetch User Dashboard Data
    APIGW-->>MobileApp: Dashboard JSON
    MobileApp->>User: Render Dashboard UI
```

### Mobile Features:
- Native-like performance and UI components.
- Secure storage for JWT authentication tokens.
- Shared backend gRPC/API Gateway consumption identical to the Web application.
