// Copyright 2021 Google LLC
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
// https://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package io.flutter.plugins.googlemobileads;

import androidx.annotation.NonNull;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.FullScreenContentCallback;

/**
 * Flutter implementation of {@link FullScreenContentCallback}. Forwards events to
 * AdInstanceManager.
 */
class FlutterFullScreenContentCallback extends FullScreenContentCallback {

  @NonNull protected final AdInstanceManager manager;
  @NonNull protected final FlutterAd ad;

  public FlutterFullScreenContentCallback(
      @NonNull AdInstanceManager manager, @NonNull FlutterAd ad) {
    this.manager = manager;
    this.ad = ad;
  }

  @Override
  public void onAdFailedToShowFullScreenContent(@NonNull AdError adError) {
    manager.onFailedToShowFullScreenContent(ad, adError);
  }

  @Override
  public void onAdShowedFullScreenContent() {
    manager.onAdShowedFullScreenContent(ad);
  }

  @Override
  public void onAdDismissedFullScreenContent() {
    manager.onAdDismissedFullScreenContent(ad);
  }

  @Override
  public void onAdImpression() {
    manager.onAdImpression(ad);
  }
}
