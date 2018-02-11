(ns github-trend-monitor.core
  (:require [clojure.java.io :as io]
            [org.httpkit.client :as http]
            [net.cgrand.enlive-html :as html]
            [incanter.core :as i]
            [incanter.excel :as xls]))

;(use '(incanter core charts excel))

(defn load-data []
  (-> (io/resource "UK2010.xls")
      (str)
      (xls/read-xls)))

(defn ex-1-1 []
  (i/col-names (load-data)))

(defn get-dom [url]
  html/html-snippet
    (:body @(http/get url {:insecure true})))

(get-dom "https://github.com/facebook/react")

#_(defn extract-stars [dom]
   (print (get-dom)))
