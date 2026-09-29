# Implementation Plan - Task_1_ProjectSetupAndData

This task involves setting up the foundation for the application, including two activities, data models for authentication and personal info, and the authentication logic using ViewModels.

## User Review Required

> [!IMPORTANT]
> The user requested two Activities: `MainActivity` and `WelcomeActivity`. I will implement `WelcomeActivity` as the entry point for authentication and `MainActivity` as the primary screen after authentication.

## Proposed Changes

### Project Configuration
#### [MODIFY] [AndroidManifest.xml](file:///D:/Thực hành mobile/app/src/main/AndroidManifest.xml)
- Register `WelcomeActivity`.
- Set `WelcomeActivity` as the launcher activity.
- Keep `MainActivity` as a secondary activity.

### Data Models
#### [NEW] [Models.kt](file:///D:/Thực hành mobile/app/src/main/java/com/example/myapplication/data/Models.kt)
- Define `UserCredentials` for auth.
- Define `PersonalInfo` (MSSV, name, image placeholder).

### ViewModels
#### [NEW] [AuthViewModel.kt](file:///D:/Thực hành mobile/app/src/main/java/com/example/myapplication/ui/AuthViewModel.kt)
- Logic to handle login/logout.
- State management for current user info.

### Activities
#### [NEW] [WelcomeActivity.kt](file:///D:/Thực hành mobile/app/src/main/java/com/example/myapplication/WelcomeActivity.kt)
- Initial screen for login.
#### [MODIFY] [MainActivity.kt](file:///D:/Thực hành mobile/app/src/main/java/com/example/myapplication/MainActivity.kt)
- Main screen content (displayed after login).

## Verification Plan

### Automated Tests
- `gradlew :app:assembleDebug` to ensure compilation.
- Unit tests for `AuthViewModel` to verify credential check.

### Manual Verification
- Verify `WelcomeActivity` launches first.
- Verify transition to `MainActivity` upon successful "login".
