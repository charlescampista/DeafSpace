package com.example.deafspace.childrenspace.modules.historymodule.enums;

public enum HistoryFragmentsTags {
    TAG_HISTORY_VIDEO_FRAGMENT("TAG_HISTORY_VIDEO_FRAGMENT"),
    TAG_HISTORY_PART_FRAGMENT("TAG_HISTORY_PART_FRAGMENT");

    private final String text;

    /**
     * @param text
     */
    HistoryFragmentsTags(final String text) {
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
