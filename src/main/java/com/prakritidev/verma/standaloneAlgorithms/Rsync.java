package com.prakritidev.verma.standaloneAlgorithms;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

public class Rsync {
    public static void main(String[] args) throws IOException, NoSuchAlgorithmException {
        String source  = "/a";
        String destination  = "/b";
        
        File sourceFile = new File(source);
        File destinationFile = new File(destination);

        if (!sourceFile.exists() || !destinationFile.exists()) {
            System.out.println("Source or destination file does not exist.");
            return;
        }

        if (sourceFile.length() == destinationFile.length() && sourceFile.lastModified() == destinationFile.lastModified()) {
            System.out.println("Files are already in sync.");
            return;
        }

        // blocks check.
        List<String> sourceChecksums = generateChecksums(sourceFile);
        List<String> destinationChecksums = generateChecksums(destinationFile);
        
        // signature generation
        List<String> signature = generateSignature(sourceChecksums);

        // transfer


        // block-level transfer
        List<String> changedBlocks = findChangedBlocks(signature, destinationChecksums);

        // patching 
        patchFile(sourceFile, destinationFile, changedBlocks);

        // verification
         List<String> patchedChecksums = generateChecksums(destinationFile);

        if(patchedChecksums.equals(sourceChecksums)){
            System.out.println("File synchronization successful.");
        } else {
            System.out.println("File synchronization failed.");
        }
    }

    private static void patchFile(File sourceFile, File destinationFile, List<String> changedBlocks) {
    }

    private static List<String> findChangedBlocks(List<String> signature, List<String> destinationChecksums) {
        return null;
    }

    private static List<String> generateSignature(List<String> sourceChecksums) {
        return null;
    }

    private static List<String> generateChecksums(File file) throws IOException, NoSuchAlgorithmException {
        
        List<String> checksums = new ArrayList<>();
        try(InputStream is = new FileInputStream(file)) {
            byte[] buffer = new byte[4096];
            MessageDigest md = MessageDigest.getInstance("MD5");

            int bytesRead;
            while((bytesRead = is.read(buffer)) != -1){
                md.update(buffer, 0, bytesRead);
                checksums.add(bytesToHex(md.digest()));
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
        return null;
    }

    private static String bytesToHex(byte[] digest) {
        StringBuilder sb = new StringBuilder();
        for(byte b: digest){
            sb.append(String.format("%2x", b));
        }
        return sb.toString();
    }
}
