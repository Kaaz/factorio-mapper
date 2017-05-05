package kaaz.start;

import javafx.application.Application;
import kaaz.gui.GuiApplication;
import kaaz.transform.Transformer;

public class Launcher {
    public static void main(String... args) throws Exception {
        String stupid = "";
//        String bp = "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";
        String bp = "0eNqVm81uG0cQhF/F2DMZ7PzP8OYHyCnHwAgoeREsQi4JkjIsCHr3kNasE8DVja6bJFuf2D01Nb3dO2/D0+FlOl/m5Tbs3ob5+bRch92fb8N1/nvZHx4/u72ep2E3zLfpOGyGZX98fHc9HfaX7Xm/TIfhfTPMy9fp+7Bz7182w7Tc5ts8fWB+fPP61/JyfJou9//wE3Ccvs4vx+10mJ5vl/l5ez4dpjv+fLref/m0PP7wA3j/hddht/Xx/X3zC83Dj/MrJHRIQJBghGQNEsm4tmtcHtGS8SN1hkOMbGNEjVFsjKLFUo2xjBqk0eldl3xEuMcfs3yo7So/1yDGGTFVpRhVvE1qSEYZb71KidSKCwElbskFSiY3Nw6okLsbUyqrP98Xy1XIa9bF6sG5Au3PKmM/qhirjF3RgvJWHbuoYgK3HYSYIrcdBApnxEJAnBMLEKuOoxqP1YyLSmHd2Kn+F0ZWfgliHCs/jPHs0ZAhJpBHA6YYVezViIwiTiokk2ueNQUFo5r15FjFrC8UbcWwEo20FWOMWcQrBlejVhEXlRLYUy9rEopWS45qhpI1QyolcwLE+SmkADGlks6OA2qks0NKMqt4dRz42JDMKm4qxtNVv7peyerJazHo8MOZVcdrZSpgErkdcI4yuR0wpXDnDA6ocucMhtC1hZrkbBS0S1p6slHPP+WHKZ6UH6yWciDVhymRPWfgc1FO5DmDKWxt4VSaUctqeoxSVhfK6MhNC6ZY9etViiNtHT6CFE+6OqbQRcV6fGKcVcj9M8FytFhlnDWI1YmDFo5RvKPGqJTwcDCN0x2EVNJ8YTSV9F4MoSuJtdqHzwzV3Gvr0oX1cDV7cNUo5no4aRGZywivUQq3BXBAldoCmNGoMwAG00bqDMAMx3UfYTDNOuVoGoS13fU5Fe7sFknRwXq8JVJ0mJK5EwA++LTCnQAYUqlGH46mUQ34gKcbI7nYmsG40XHt/Igp5KxOoLDO6zGGtV4Bk8gmH6ZksuGNKYU94qIqof+0fDk9nc6nyw0gxt/6Z7p/gTGNHAXhMdvIaUegkGaM19yRbixQAtcuFCKKXOdcoCS6Is9qnjPXiMcTN+vgbn08ECiUJQsMypIxw7OO3A9OgeaoZh9eJuu4TlWgeVjX1xqbjXlY19daoHBujDem58xYgLBeHDQY1VYTUtOYdjdmWMd0fY1wMNYhXZeLAPGceeJSwjyh67tIoNAv/jSNxvXT8JkbMtVYFiCF6isL4VSmrSwwGiU7HI11Oue0lETOdXE4kXNdAUL30Ho5nDEuco29gimJa28LlMy1t4WICtfeFiiV2gNCQI3ZA5hhHcslJRjrTK5qDE/14oRgjL7rtawm1nZ7ZxvvbPMorotOeOstc6ITKIU6AvDrZdZRXD8CBEhjGmDCO3wj04sWGPQ7w6OiHOsUrveccGqsQ7hexQsQ0nbxbMdl0nclTKY6YHjE6TLXAZYo/OuWmn4a01AW0mMdxAUV4ijtCdmxzuG6+CRKoLxciihSZi5REteOw693OPMEbs2MgKE7ab1slDJduTY3fpPBWUdy/QFDoFhncqOWIetMLqgQzxwvUjiBOV8kCFtMrH0VAZeoDqGUHqOYe2EjUQqpPVwgWWdyq/YESuOOGPzwY53LrUeMQGGLiqTSPNMiFNLTAtUrlyiR6pVLASWqVy5RMunr+LHDPJxbfV3A0FVFUXGN6hRKNzhG6p6CRHHMPQUckLdO6KIKCZz8hHgiJz+BQhqxEBFpxAKFLyr6p8LXQcZKjn4axjSufy9g2Pt0QlDkfTqJ4qnNIEQUqM0gQKjbdFI43G06icK+Y+mjtrXY6Ry+Xuqt47l1ZCNQOCfGV/y855xYotDNCq8pyH6n7kND+PasZ8d0EoYtlEdt2Tw/d+6pv9e6XzYf99F3/7u+vhkO+6d7WLvh9/3h9M+8fPrjEeynz5fL/vX+r9+my/UHLcfoYyqxlbtZ/wvYl39t";
        System.out.println("INPUT:");
        Application.launch(GuiApplication.class, args);
        System.out.println(bp);
        Transformer.fromGameBluePrint(bp);
    }
}