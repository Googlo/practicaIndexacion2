/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package consultas;

import java.util.StringTokenizer;

/**
 *
 * @author moulay
 */
public class Document {
    private String documentId;
    private StringTokenizer tokens;
    
    public Document(String documentId, StringTokenizer tokens) {
        this.documentId = documentId;
        this.tokens = tokens;
    }
    
    public String getDocumentId() {
        return documentId;
    }
    
    public StringTokenizer getTokens() {
        return tokens;
    }
}
