public class Main {
    public static void main(String[] args) {
        String mdp = "zzzz999";
        boolean mdpValue = false;
        int compteur = 1;
        for (char h = 'a'; h <= 'z'; h++) {
            for (char i = 'a'; i <= 'z'; i++) {
                if (mdpValue) {
                    break;
                }
                for (char j = 'a'; j <= 'z'; j++) {
                    if (mdpValue) {
                        break;
                    }
                    for (char k = 'a'; k <= 'z'; k++) {
                        if (mdpValue) {
                            break;
                        }
                        for (int l = 0; l <= 9; l++) {
                            if (mdpValue) {
                                break;
                            }
                            for (int m = 0; m <= 9; m++) {
                                if (mdpValue) {
                                    break;
                                }
                                for (int n = 0; n <= 9; n++) {
                                    System.out.println("N : " + compteur + " " +h+"" + i + "" + j + "" + k + "" + l + "" + m + "" + n);
                                    compteur++;
                                    if ((i + "" + j + "" + k + "" + l + "" + m + "" + n).equals(mdp)) {
                                        System.out.println("Bravo");
                                        mdpValue = true;
                                        break;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

}
