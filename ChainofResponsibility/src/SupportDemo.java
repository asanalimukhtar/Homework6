public class SupportDemo {
    public static void main(String[] args) {
        // here we create handlers
        SupportHandler faq = new FAQBotHandler();
        SupportHandler junior = new JuniorSupportHandler();
        SupportHandler senior = new SeniorSupportHandler();

        // Formation of a chain: FAQBot -> JuniorSupport -> SeniorSupport
        faq.set_next(junior).set_next(senior);

        // List of applications for testing
        String[] issues = {"password_reset", "refund_request", "account_ban", "unknown_bug"};

        // This part is the code for processing each request
        for (String issue : issues) {
            faq.handle(issue);
        }
    }
}