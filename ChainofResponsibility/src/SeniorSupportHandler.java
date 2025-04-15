public class SeniorSupportHandler implements SupportHandler {
    private SupportHandler nextHandler;

    @Override
    public SupportHandler set_next(SupportHandler handler) {
        this.nextHandler = handler;
        return handler;
    }

    @Override
    public void handle(String issue) {
        if ("account_ban".equals(issue) || "data_loss".equals(issue)) {
            Logger.getInstance().log("[SeniorSupport] Handled " + issue);
        } else {
            Logger.getInstance().log("[SeniorSupport] Cannot handle " + issue + " — escalate manually");// If the chain is complete and the request is not processed, display a message
            // If we need throw an exception if necessary
            // throw new RuntimeException("Unhandled issue: " + issue);
        }
    }
}