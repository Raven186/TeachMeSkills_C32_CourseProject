package com.courseproject.twoFA;
import com.courseproject.exception.fileException.WrongLoginException;
import com.courseproject.logger.Logger;
import com.google.zxing.WriterException;

import java.io.IOException;
import java.util.Scanner;
    /**
     * The TFALaunch class is responsible for starting the two-factor authentication (2FA) process.
     * It generates a QR code, verifies the entered code, and returns the authentication result.
     */
    public class twoFARunner {
        /**
         * The launchTFA method starts the two-factor authentication check.
         *
         * Execution steps:
         * - Generates a secret key, email address, and company name.
         * - Creates a URL for Google Authenticator and generates a QR code based on it.
         * - Waits for the user to enter a code.
         * - Compares the entered code with the calculated one-time code.
         * - Returns true if the code is correct, or false if the code is incorrect.
         *
         * @return true if two-factor authentication is successful; false if an error occurs.
         */
        public static boolean launchTFA() {
            // Data for 2FA
            String secretKey = "QDWSM3OYBPGTEVSPB5FKVDM3CSNCWHVK";
            String email = "ilya_kate@gmail.com";
            String companyName = "Kate's and Ilya's corp.";
            // Generate URL for Google Authenticator
            String barCodeUrl = twoFAHelpers.getGoogleAuthenticatorBarCode(secretKey, email, companyName);

            try {
                // Generate QR code
                twoFAHelpers.createQRCode(barCodeUrl, "src/main/resources/QRCode.png", 400, 400);
            } catch (WriterException | IOException e) {
                Logger.errorLogs("Error creating QR code: " + e.getMessage());
                throw new RuntimeException("Error creating QR code", e);
            }
            // Waiting for the user to enter the code
            System.out.print("Please enter 2fA code here: ");
            Scanner scanner = new Scanner(System.in);
            String code = scanner.nextLine();
            // Checking the entered code for correctness
            if (code.equals(twoFAHelpers.getTOTPCode(secretKey))) {
                Logger.actionLogs("Two-factor authentication completed successfully");
                return true;
            } else {
                WrongLoginException loginFailedException = new WrongLoginException("Error: Invalid authentication code", new Throwable("Invalid code"));
                Logger.errorLogs(loginFailedException.getMessage());
                throw loginFailedException;
            }
        }
    }
