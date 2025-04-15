public interface SupportHandler {
    SupportHandler set_next(SupportHandler handler);
    // we set the next handler here and return it for cascade call

    void handle(String issue); //if someone doesn't know, this method processes the submitted request
}