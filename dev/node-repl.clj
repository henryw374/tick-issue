(ns node-repl
  (:require [cljs.repl :as cljs-repl]
            [cljs.repl.node :as node])
  (:import (java.time ZoneId)))


(defn node-repl []
  (cljs-repl/repl* (node/repl-env)
    {:output-dir "out"
     :optimizations :none
     :cache-analysis true
     :source-map true
     :install-deps true
     :npm-deps {:js-joda "1.10.1"
                "@js-joda/locale_en-us"  "2.0.0"
                :js-joda-timezone "2.0.1"}}))

(comment 
  
  (node-repl)
  (require 'tick)
  
  ;(require 'cljsjs.js-joda)
  ;(require 'cljsjs.js-joda-timezone)
  ;(require 'cljsjs.js-joda-locale-en-us)
  (require '[tick.alpha.api :as t])
  
  ;(set! js/JSJoda (js/require "js-joda"))
  (.. js/JSJoda -ZoneId (of "Europe/London"))

  
  ; works
  (t/truncate (t/instant 1552786820310) :seconds)

  ; works
  (t/format (t/truncate (t/instant 1552786820310) :seconds))

  ; error
  (t/format :iso-instant (t/truncate (t/instant 1552786820310) :seconds))
  ; Execution error (RangeError) at (<cljs repl>:1) .
  ; Maximum call stack size exceeded

  ; error
  (t/format :iso-zoned-date-time (t/truncate (t/instant 1552786820310) :seconds))
  ; Execution error (RangeError) at (<cljs repl>:1) .
  ; Maximum call stack size exceeded

  ; error
  (t/in (t/truncate (t/instant 1552786820310) :seconds) "Europe/London")
  ; Execution error (Error) at (<cljs repl>:1) .
  ; unsupported ZoneId:Europe/London

  ; error
  (t/in (t/truncate (t/instant 1552786820310) :seconds) (t/zone "Europe/London"))
  ; Execution error (Error) at (<cljs repl>:1) .
  )

 