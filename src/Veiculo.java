class Veiculo {
    private String id;
    private String tipo;

    public Veiculo(String id, String tipo) {
        this.id = id;
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "Veiculo{" + "id='" + id + "', tipo='" + tipo + "'}";
    }
}
