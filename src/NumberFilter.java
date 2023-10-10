class NumberFilter implements Filter<Number> {
    @Override
    public boolean apply(Number element) {
        return element.intValue() % 2 == 0;
    }
}