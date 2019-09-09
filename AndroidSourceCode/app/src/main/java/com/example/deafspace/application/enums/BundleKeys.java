package com.example.deafspace.application.enums;

public enum BundleKeys {
    VOCABULARY_ELEMENT("VOCABULARY_ELEMENT");

    private final String text;

    /**
     * @param text
     */
    BundleKeys(final String text) {
        this.text = text;
    }

    /* (non-Javadoc)
     * @see java.lang.Enum#toString()
     */
    @Override
    public String toString() {
        return text;
    }


}
