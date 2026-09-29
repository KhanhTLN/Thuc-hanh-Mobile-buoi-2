# Project Plan

Một ứng dụng Android (Kotlin) có 2 Activity: MainActivity và WelcomeActivity. 
MainActivity: Giao diện đăng nhập với trường tài khoản, mật khẩu và nút Login.
Logic: Kiểm tra tài khoản/mật khẩu. Nếu sai, hiện thông báo. Nếu đúng, chuyển sang WelcomeActivity.
WelcomeActivity: Hiển thị MSSV, Họ tên và Ảnh cá nhân.

## Project Brief

# Project Brief: Student Login & Profile App

This project is a Minimum Viable Product (MVP) for a simple Android application designed to handle user authentication and display student profile information using modern Android development practices.

## Features
- **Secure Login Interface**: A primary screen for users to input their account credentials and password.
- **Credential Validation**: Logic to verify user inputs, providing immediate feedback (error messages) for incorrect credentials.
- **State-Driven Navigation**: Seamless transition from the login screen to the welcome screen upon successful authentication.
- **Student Profile Display**: A dedicated welcome screen that presents the student's ID (MSSV), full name, and a personal profile photograph.

## High-Level Technical Stack
- **Kotlin**: The core programming language used for app logic and UI implementation.
- **Jetpack Compose**: The modern toolkit for building native, declarative UI.
- **Jetpack Navigation 3**: Used for managing app state and screen transitions in a state-driven manner.
- **Compose Material Adaptive**: Implementation of adaptive layouts to ensure the UI looks great on various device form factors.
- **Kotlin Coroutines**: For handling asynchronous tasks, such as authentication checks, without blocking the UI thread.
- **ViewModel**: To manage UI-related data in a lifecycle-conscious way and facilitate communication between the UI and logic layers.

## Implementation Steps
**Total Duration:** 21m 45s

### Task_1_ProjectSetupAndData: Configure dependencies, data models, and ViewModels for authentication and profile management.
- **Status:** COMPLETED
- **Updates:** Configured project dependencies, data models, and AuthViewModel. Note: The coder agent made WelcomeActivity the login screen and MainActivity the destination screen, which is reversed from the user request. This will be corrected in Task 2/3.
- **Acceptance Criteria:**
  - Project builds successfully
  - Data models and ViewModels implemented
- **Duration:** 21m 45s

### Task_2_MainActivityLoginUI: Implement MainActivity using Jetpack Compose for the login screen, with input fields and validation feedback.
- **Status:** IN_PROGRESS
- **Acceptance Criteria:**
  - Login UI implemented using Jetpack Compose
  - Credential validation feedback works
- **StartTime:** 2026-09-22 09:17:21 GMT+07:00

### Task_3_WelcomeActivityProfileUI: Implement WelcomeActivity using Jetpack Compose to display student details including MSSV, full name, and profile photograph.
- **Status:** PENDING
- **Acceptance Criteria:**
  - Welcome UI implemented using Jetpack Compose
  - Displays student ID, full name, and photograph correctly

### Task_4_NavigationAndVerification: Connect MainActivity and WelcomeActivity via Intent navigation upon successful login, run the app, and verify application stability (no crashes).
- **Status:** PENDING
- **Acceptance Criteria:**
  - Successful login navigates to WelcomeActivity
  - build pass
  - app does not crash
  - make sure all existing tests pass

