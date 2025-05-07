# Diagramas de Arquitectura

## Diagrama de Clases

```mermaid
classDiagram
    class AuthApplication {
        +main(args: String[]): void
    }
    
    class AuthController {
        +showLoginForm(): String
        +processLogin(LoginRequest, Model): String
    }
    
    class LoginRequest {
        -username: String
        -password: String
        +getUsername() String
        +getPassword() String
    }
    
    AuthController --> LoginRequest
    AuthController --> Model
```

## Diagrama de Secuencia

```plantuml
@startuml
!include docs/templates/spring-colors.puml

actor Usuario
participant Controller
participant Service

Usuario -> Controller : Request
Controller -> Service : Llamada
Service --> Controller : Respuesta
Controller --> Usuario : Response
@enduml
```
