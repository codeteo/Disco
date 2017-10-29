package com.disco.man.discogman.domain.features.wantlist;

import io.reactivex.Single;
import okhttp3.ResponseBody;

/**
 * Use case for getting wantlist.
 */

public interface GetWantlistUseCase {

    Single<ResponseBody> getWantlist(String username, String authHeader);
}
