package com.example.deafspace.childrenspace.modules.historymodule.enums;

public enum HistoryBundleKeys {
    HiSTORY_PART("HiSTORY_PART");

    private final String text;

    /**
     * @param text
     */
    HistoryBundleKeys(final String text) {
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
