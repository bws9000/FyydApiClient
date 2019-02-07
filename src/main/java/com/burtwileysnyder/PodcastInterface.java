package com.burtwileysnyder;

import java.io.IOException;

interface PodcastInterface {
    String searchPodcasts(String title, String limit) throws IOException;
}
