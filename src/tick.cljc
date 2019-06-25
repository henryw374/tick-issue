(ns tick
  (:require [cljsjs.js-joda]
            [cljsjs.js-joda-timezone]
            [cljsjs.js-joda-locale-en-us]
            [tick.alpha.api :as t]
            [tick.timezone]))

; ok
(def inst (t/truncate (t/instant 1561224025879) :seconds))

; ok
(t/format inst)

; ok on clj, error on cljs
(t/format :iso-instant inst)

; ok on clj, error on cljs
(t/in inst "Europe/London")