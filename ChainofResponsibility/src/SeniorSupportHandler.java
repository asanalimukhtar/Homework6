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
            Logger.getInstance().log("[SeniorSupport] Cannot handle " + issue + " — escalate manually");
            // При необходимости можно выбросить исключение:
            // throw new RuntimeException("Unhandled issue: " + issue);
        }
    }
}