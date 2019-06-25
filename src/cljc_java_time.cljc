(ns cljc-java-time
  (:require [cljc.java-time.instant :as ti]
            [cljc.java-time.temporal.chrono-unit :as tu]
            #?(:cljs [cljsjs.js-joda-timezone])
            [cljc.java-time.zone-id :as tz]))

; ok
(def inst (ti/truncated-to (ti/of-epoch-milli 1561224025879) tu/seconds))

; ok on clj, empty on cljs
(tz/get-available-zone-ids)
