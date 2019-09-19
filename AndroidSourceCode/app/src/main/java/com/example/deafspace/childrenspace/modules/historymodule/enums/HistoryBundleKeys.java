package com.example.deafspace.childrenspace.modules.historymodule.enums;

public enum HistoryBundleKeys {
    HiSTORY_PART_SIGN("HiSTORY_PART_SIGN"),
    HiSTORY_PART_ANIMATION("HiSTORY_PART_ANIMATION"),
    HISTORY_SINGLE_PART_ARGUMENT("HISTORY_SINGLE_PART_ARGUMENT");

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
