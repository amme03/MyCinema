package coma.example.anamarrugo.mycinema.repository;

/**
 * Created by ana.marrugo on 12/12/2017.
 */

public class RepositoryError extends Exception {

    private int idError;

    public RepositoryError(String message) {
        super(message);
    }

    public int getIdError() {
        return idError;
    }

    public void setIdError(int idError) {
        this.idError = idError;
    }

}