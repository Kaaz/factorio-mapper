package kaaz.transform;

import com.google.gson.Gson;
import kaaz.common.BuildPlan;
import kaaz.common.Buildable;
import kaaz.factorio.Entities;
import kaaz.gson.Blueprint;
import kaaz.gson.BlueprintRoot;
import kaaz.gson.Entity;
import org.apache.commons.codec.binary.Base64;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;

import static org.apache.commons.codec.CharEncoding.UTF_8;

public class Transformer {

    public static BuildPlan fromGameBluePrint(String blueprint) {
        if (blueprint == null || blueprint.length() < 1) {
            return null;
        }
        String bp = blueprint.substring(1);
        String decodedString = null;
        try {
            byte[] decodedBytes = Base64.decodeBase64(bp.getBytes(UTF_8));
            decodedString = new String(decompressZLib(decodedBytes), UTF_8);
        } catch (UnsupportedEncodingException e) {
            return null;
        }
//        System.out.println("Decoded string: ");
//        System.out.println(decodedString);
        Gson gson = new Gson();
        BlueprintRoot blueprintRoot = gson.fromJson(decodedString, BlueprintRoot.class);
        return toBuildPlan(blueprintRoot.getBlueprint());
    }

    public static BuildPlan toBuildPlan(Blueprint bp) {
        BuildPlan plan = new BuildPlan();
        for (Entity entity : bp.getEntities()) {
            plan.addEntity(new Buildable(Entities.fromCode(entity.getName()), entity.getPosition().getX(), entity.getPosition().getY()));
        }
        return plan;
    }

    public static void toGameBlueprint() {

    }

    public static byte[] decompressZLib(byte[] bytesToDecompress) {
        byte[] returnValues = null;
        Inflater inflater = new Inflater();
        int numberOfBytesToDecompress = bytesToDecompress.length;
        inflater.setInput(bytesToDecompress, 0, numberOfBytesToDecompress);
        List<Byte> bytesDecompressedSoFar = new ArrayList<>();
        try {
            while (!inflater.needsInput()) {
                byte[] bytesDecompressedBuffer = new byte[numberOfBytesToDecompress];
                int numberOfBytesDecompressedThisTime = inflater.inflate(bytesDecompressedBuffer);
                for (int b = 0; b < numberOfBytesDecompressedThisTime; b++) {
                    bytesDecompressedSoFar.add(bytesDecompressedBuffer[b]);
                }
            }
            returnValues = new byte[bytesDecompressedSoFar.size()];
            for (int b = 0; b < returnValues.length; b++) {
                returnValues[b] = bytesDecompressedSoFar.get(b);
            }
        } catch (DataFormatException dfe) {
            dfe.printStackTrace();
        }
        inflater.end();
        return returnValues;
    }
}
