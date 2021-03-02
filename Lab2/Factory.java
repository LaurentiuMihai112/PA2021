public class Factory extends Source {
    public Factory(String name, int supply) {
        super(name, supply, SourceType.FACTORY);
    }

    @Override
    public int getSupply() {
        return super.getSupply();
    }

    @Override
    public void setSupply(int supply) {
        super.setSupply(supply);
    }

    @Override
    public int[] getPrice() {
        return super.getPrice();
    }

    @Override
    public void setPrice(int[] price) {
        super.setPrice(price);
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public void setName(String name) {
        super.setName(name);
    }
}
