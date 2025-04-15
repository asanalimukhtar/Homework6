public class FAQBotHandler implements SupportHandler {
    private SupportHandler nextHandler;

    @Override
    public SupportHandler set_next(SupportHandler handler) {
        this.nextHandler = handler;
        return handler;
    }

    @Override
    public void handle(String issue) {
        if ("password_reset".equals(issue)) {
            Logger.getInstance().log("[FAQBot] Handled " + issue);
        } else if (nextHandler != null) {
            nextHandler.handle(issue);// Pass the request to the next handler
        } else {
            Logger.getInstance().log("[FAQBot] Cannot handle " + issue + " — escalate manually");// If the chain is complete and the request is not processed, display a message
        }
    }
}