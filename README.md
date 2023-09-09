# Imguram-Insta-Clone


Imguram is an Android app that serves as a clone of Instagram, leveraging the Imgur API to provide various features like watching stories, browsing feeds, and more. With Imguram, users can enjoy a visually engaging experience similar to Instagram, while also exploring the unique content available on Imgur. This README file provides an overview of the app, installation instructions, and usage guidelines.



<img src="/screenshots/ss0.jpg" alt="App Screenshot" width="300">



## Table of Contents
- [Features](#features)
- [Installation](#installation)
- [Usage](#usage)
- [Screenshots](#screenshots)
- [Contributing](#contributing)
- [License](#license)

## Features

### Imgur API Integration
- Utilizes the Imgur API to fetch user-generated content.
- Provides access to a vast library of images, gifs, and videos from Imgur.

### Feed
- Browse through a feed of images and videos.
- Choose between "Hot" and "Top" feeds for diverse content.

### Stories
- Watch stories posted by other users.
- Upload and manage your own stories.


## Installation

To run Imguram on your Android device, follow these steps:

1. Clone this GitHub repository:
   ```shell
   git clone https://github.com/IamAbhinavSINGH/Imguram-Insta-Clone.git
   ```
2. Open the project in Android Studio.

3. Configure your Imgur API credentials:
   - Create an Imgur API application on the Imgur website (https://apidocs.imgur.com/).
   - Obtain your client ID and client secret.
   - Insert your API_KEY in the [ImgurClient.kt](/libImgurApi/src/main/java/com/abhinav/libimgurapi/ImgurClient.kt).

4. Build and run the app on your Android emulator or physical device.

5. Start using Imguram and enjoy its Instagram-like features!


## Usage

1. **Login/Signup**: Launch the app and create an account or log in with existing credentials.

2. **Feed**: Explore the "Hot" and "Top" feeds to discover trending content.

3. **Stories**: Access stories from other users and upload your own by tapping your profile picture.


## Screenshots

<img src="/screenshots/ss1.jpg" alt="App Screenshot" width="300">  <img src="/screenshots/ss2.jpg" alt="App Screenshot" width="300">


## Contributing

I welcome the contributions to make Imguram even better! If you'd like to contribute, please follow these steps:

1. Fork the repository.
2. Create a new branch for your feature or bug fix.
3. Make your changes and ensure they follow the project's coding standards.
4. Test your changes thoroughly.
5. Create a pull request to merge your branch into the main repository.
6. Wait for the maintainers to review your pull request and address any feedback.

## License

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.

---

Thank you for using Imguram! If you encounter any issues or have suggestions for improvements, please open an issue on this GitHub repository. Happy browsing!
