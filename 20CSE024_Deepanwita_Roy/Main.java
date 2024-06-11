// New component interface for OTP verification
interface OTPVerification {
    void verifyOTP(String otp);
}
// Deepanwita Roy 
// Concrete component for OTP verification
class OTPVerifier implements OTPVerification {
    @Override
    public void verifyOTP(String otp) {
        System.out.println("Verifying OTP: " + otp);
        // Add your OTP verification logic here
    }
}
// Deepanwita Roy 
// Updated Decorator base class
abstract class OTPVerificationDecorator implements OTPVerification {
    private final OTPVerification otpVerification;

    public OTPVerificationDecorator(OTPVerification otpVerification) {
        this.otpVerification = otpVerification;
    }

    @Override
    public void verifyOTP(String otp) {
        otpVerification.verifyOTP(otp);
    }
}
// Deepanwita Roy 
// Updated Concrete Decorators
class SMSDeliveryDecorator extends OTPVerificationDecorator {
    public SMSDeliveryDecorator(OTPVerification otpVerification) {
        super(otpVerification);
    }

    @Override
    public void verifyOTP(String otp) {
        super.verifyOTP(otp);
        System.out.println("Verifying OTP via SMS: " + otp);
    }
}

class EmailDeliveryDecorator extends OTPVerificationDecorator {
    public EmailDeliveryDecorator(OTPVerification otpVerification) {
        super(otpVerification);
    }

    @Override
    public void verifyOTP(String otp) {
        super.verifyOTP(otp);
        System.out.println("Verifying OTP via Email: " + otp);
    }
}

class CreditCardDecorator extends OTPVerificationDecorator {
    public CreditCardDecorator(OTPVerification otpVerification) {
        super(otpVerification);
    }

    @Override
    public void verifyOTP(String otp) {
        super.verifyOTP(otp);
        System.out.println("Verifying OTP for Credit Card transaction.");
    }
}

class DebitCardDecorator extends OTPVerificationDecorator {
    public DebitCardDecorator(OTPVerification otpVerification) {
        super(otpVerification);
    }

    @Override
    public void verifyOTP(String otp) {
        super.verifyOTP(otp);
        System.out.println("Verifying OTP for Debit Card transaction.");
    }
}

class BankAccountDecorator extends OTPVerificationDecorator {
    public BankAccountDecorator(OTPVerification otpVerification) {
        super(otpVerification);
    }

    @Override
    public void verifyOTP(String otp) {
        super.verifyOTP(otp);
        System.out.println("Verifying OTP for Bank Account transaction.");
    }
}

// Updated Client code
public class Main {
    public static void main(String[] args) {
        // Initial setup with OTP verification
        OTPVerification otpVerifier = new OTPVerifier();

        // Decorate with additional OTP delivery methods
        OTPVerification smsVerification = new SMSDeliveryDecorator(otpVerifier);
        OTPVerification emailVerification = new EmailDeliveryDecorator(smsVerification);

        // Decorate with additional money addition methods
        OTPVerification creditCardVerification = new CreditCardDecorator(emailVerification);
        OTPVerification debitCardVerification = new DebitCardDecorator(creditCardVerification);
        OTPVerification bankAccountVerification = new BankAccountDecorator(debitCardVerification);

        // Simulate an add money transaction with OTP verification
        double amountToAdd = 100.0;
        String userOTP = "123456";

        bankAccountVerification.verifyOTP(userOTP);
        bankAccountVerification.verifyOTP("incorrectOTP");  // Simulate an incorrect OTP

        // Add money using the decorated method
        bankAccountVerification.verifyOTP(userOTP);
        bankAccountVerification.verifyOTP("incorrectOTP");  // Simulate an incorrect OTP
    }
}
