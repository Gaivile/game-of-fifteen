(ns game-of-fifteen.core
    (:require [reagent.core :as reagent]
              [re-frame.core :as re-frame]
              [game-of-fifteen.events]
              [game-of-fifteen.subs]
              [game-of-fifteen.views :as views]
              [game-of-fifteen.config :as config]))


(defn dev-setup []
  (when config/debug?
    (enable-console-print!)
    (println "dev mode")))

(defn mount-root []
  (re-frame/clear-subscription-cache!)
  (reagent/render [views/main-panel]
                  (.getElementById js/document "app")))

(defn ^:export init []
  (re-frame/dispatch-sync [:initialize-db])
  (dev-setup)
  (mount-root))
