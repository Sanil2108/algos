
public class Proofs {
    public enum ProofTypes {
        SkewSymmetric, Symmetric, Orthogonal, Idempotent, Nilpotent, Unitary, Hermatian, SkewHermatian
    }
    private static boolean checkOrthogonal(Matrice m1){
        return (Matrice.equals(m1, Matrice.getTranspose(m1)));
    }
    private static boolean checkIdempotent(Matrice m1){
        return (Matrice.equals(m1, Matrice.multiplyMatrice(m1, m1)));
    }
    private static boolean checkNilpotent(Matrice m1){
        return (Matrice.equals(Matrice.multiplyMatrice(m1, m1), new Matrice(m1.getOrderP(), m1.getOrderQ(), Matrice.Type.ZeroM)));
    }
    private static boolean checkSkewSymmetric(Matrice m1){
        return (Matrice.equals(m1, (Matrice.getTranspose(m1)).scalarMultiplication(-1)));
    }
    private static boolean checkSymmetric(Matrice m1){
        return (Matrice.equals(m1, (Matrice.getTranspose(m1))));
    }
    public static boolean checkProof(Matrice m1, ProofTypes proofTypes){
        switch (proofTypes){
            case Orthogonal:
                return checkOrthogonal(m1);
            case Idempotent:
                return checkIdempotent(m1);
            case Nilpotent:
                return checkNilpotent(m1);
            case SkewSymmetric:
                return checkSkewSymmetric(m1);
            case Symmetric:
                return checkSymmetric(m1);
            default:
                System.out.println("Proof of this matrice is not available yet");
                return false;
        }
    }
}
