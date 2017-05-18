package org.wikipedia.dataclient.mwapi;

import android.support.annotation.Nullable;
import android.support.annotation.VisibleForTesting;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MwQueryResponse<T> extends MwResponse {

    @SuppressWarnings("unused") @SerializedName("batchcomplete")
    private boolean batchComplete;

    @Nullable private T query;

    public boolean batchComplete() {
        return batchComplete;
    }

    @Nullable public T query() {
        return query;
    }

    @Override public boolean success() {
        return super.success() && query != null;
    }

    @VisibleForTesting
    protected void setQuery(@Nullable T query) {
        this.query = query;
    }

    public static class Pages {
        private List<MwQueryPage> pages;

        public List<MwQueryPage> pages() {
            return pages;
        }
    }
}
