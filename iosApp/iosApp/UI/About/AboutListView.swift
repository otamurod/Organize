//
//  AboutListView.swift
//  iosApp
//
//  Created by Otamurod Safarov on 15/07/24.
//  Copyright © 2024 orgName. All rights reserved.
//

import Shared
import SwiftUI

struct AboutListView: View {
    struct RowItem: Hashable {
        let title: String
        let subtitle: String
    }

    private let items: [RowItem] = {
        let platform = Platform()

        var result: [RowItem] = [
            .init(
                title: "Operating System",
                subtitle: "\(platform.osName) \(platform.osVersion)"
            ),
            .init(
                title: "Device",
                subtitle: platform.deviceModel
            ),
            .init(
                title: "CPU",
                subtitle: platform.cpuType
            )
        ]

        let width = min(platform.screen.width, platform.screen.height)

        let height = max(platform.screen.width, platform.screen.height)

        var displayValue = "\(width)×\(height)"

        if let density = platform.screen.density {
            displayValue += " @\(density)x"
        }

        result.append(
            .init(
                title: "Display",
                subtitle: displayValue
            )
        )

        return result
    }()

    var body: some View {
        List {
            ForEach(items, id: \.self) { item in
                VStack(alignment: .leading) {
                    Text(item.title)
                        .font(.footnote)
                        .foregroundStyle(.secondary)
                    Text(item.subtitle)
                        .font(.body)
                        .foregroundStyle(.primary)
                }
                .padding(.vertical, 4)
            }
        }
    }
}

#Preview {
    AboutListView()
}
