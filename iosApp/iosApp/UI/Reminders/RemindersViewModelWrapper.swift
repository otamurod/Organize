//
//  RemindersViewModelWrapper.swift
//  iosApp
//
//  Created by Otamurod Safarov on 20/07/24.
//  Copyright © 2024 orgName. All rights reserved.
//

import Combine
import Shared

final class RemindersViewModelWrapper: ObservableObject {
    let viewModel: RemindersViewModel = Koin.instance.get()

    @Published private(set) var reminders: [Reminder] = []

    init() {
        let collector = Collector<[Reminder]> { [weak self] items in
            DispatchQueue.main.async {
                self?.reminders = items
            }
        }

        viewModel.reminders.collect(collector: collector) { error in
            if let error = error {
                // handle error
                print("Error collecting reminders: \(error)")
            }
        }
    }
}

// MARK: We must create Swift collector for Kotlin Coroutines Flow

class Collector<T>: Kotlinx_coroutines_coreFlowCollector {
    let callback: (T) -> Void

    init(callback: @escaping (T) -> Void) {
        self.callback = callback
    }

    func emit(value: Any?, completionHandler: @escaping (Error?) -> Void) {
        if let value = value as? T {
            callback(value)
        }
        completionHandler(nil)
    }
}
