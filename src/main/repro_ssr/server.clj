(ns repro-ssr.server
  (:require
    [fulcro.easy-server :refer [make-fulcro-server]]
    [fulcro.client.dom-server :as dom]
    [fulcro.client.primitives :as prim]
    ; MUST require these, or you won't get them installed.
    [repro-ssr.api.read]
    [repro-ssr.api.mutations]
    [repro-ssr.ui.root :as root]
    ))

(defn ssr
  []
  (let [root-factory (prim/factory root/Root)]
    (dom/render-to-str (root-factory {}))))

(defn build-server
  [{:keys [config] :or {config "config/dev.edn"}}]
  (make-fulcro-server
    :parser-injections #{:config}
    :config-path config))



