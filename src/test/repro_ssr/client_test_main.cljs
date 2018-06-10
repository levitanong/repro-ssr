(ns ^:dev/always repro-ssr.client-test-main
  (:require [fulcro-spec.selectors :as sel]
            [fulcro-spec.suite :as suite]))

(suite/def-test-suite client-tests {:ns-regex #"repro-ssr.*-spec"}
  {:default   #{::sel/none :focused}
   :available #{:focused}})

(client-tests)
