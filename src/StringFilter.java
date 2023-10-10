class StringFilter implements Filter<String> {
    @Override
    public boolean apply(String element) {
        return element.length() > 5;
    }
}
