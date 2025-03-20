public class stackGenericResult<T> {

    private boolean isOk;
    private T value;    

    public stackGenericResult(boolean isOk, T value) {
        this.isOk = true;
        this.value = value;
    }

    public boolean isOk() {
        return isOk;
    }

    public T value() {
        return value;
    }
}
